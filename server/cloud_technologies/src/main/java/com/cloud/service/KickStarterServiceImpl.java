package com.cloud.service;

import com.cloud.ViewModel.ProjectVM;
import com.cloud.config.CSVReader;
import com.cloud.model.KickStarter;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.RelationalGroupedDataset;
import org.apache.spark.sql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.spark.sql.functions.col;

/**
 * <p>Class for implementing main functionalities of the assignment</p>
 */
@Service
public class KickStarterServiceImpl implements IKickStarterService{

    private CSVReader csvReader;

    @Autowired
    public KickStarterServiceImpl(CSVReader csvReader){
        this.csvReader = csvReader;
    }


    public void test(){
        Dataset<KickStarter> dataset = csvReader.getCSVRecords();
        RelationalGroupedDataset groupedDataset = dataset.where(col("name").like("%an%")).groupBy(col("ID"));
        groupedDataset.count().show();
    }

    @Override
    public List<KickStarter> findProjects(ProjectVM projectVM) {
        MessageFormat fmt = new MessageFormat("%{0}%");
        Dataset<KickStarter> dataset = csvReader.getCSVRecords();
        Dataset<KickStarter> searched =
                dataset.where(
                        col("main_category").like("%"+projectVM.getCategory()+"%")
                                .and(col("category").like("%"+projectVM.getSubCategory()+"%"))
                                .and(col("country").like("%"+projectVM.getCountry()+"%")))
                        .orderBy(col("ID").desc());
        List<KickStarter> rows = searched.collectAsList();
        System.out.println("xxxxx");
        return rows.stream().collect(Collectors.toList());
    }


}

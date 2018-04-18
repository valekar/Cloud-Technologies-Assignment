package com.cloud.service;

import com.cloud.ViewModel.ProjectVM;
import com.cloud.config.CSVReader;
import com.cloud.model.KickStarter;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.RelationalGroupedDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

import static org.apache.spark.sql.functions.col;

//import org.apache.spark.api.java.function.Function;

/**
 * <p>Class for implementing main functionalities of the assignment</p>
 */
@Service
public class KickStarterServiceImpl implements IKickStarterService {

    private CSVReader csvReader;

    @Autowired
    public KickStarterServiceImpl(CSVReader csvReader) {
        this.csvReader = csvReader;
    }


    public void test() {
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
                        col("main_category").like("%" + projectVM.getCategory() + "%")
                                .and(col("category").like("%" + projectVM.getSubCategory() + "%"))
                                .and(col("country").equalTo(projectVM.getCountry())))
                        .orderBy(col("ID").desc());
        dataset.show();
        //Dataset<KickStarter> rows = dataset.;
        Dataset<KickStarter> rows = searched.filter(col("ID").isNotNull()
                .and(col("name").isNotNull())
                .and(col("category").isNotNull())
                .and(col("main_category").isNotNull())
                .and(col("currency").isNotNull())
                .and(col("deadline").isNotNull())
                .and(col("goal").isNotNull())
                .and(col("launched").isNotNull())
                .and(col("pledged").isNotNull())
                .and(col("state").isNotNull())
                .and(col("backers").isNotNull())
                .and(col("country").isNotNull())
                .and(col("usd_pledged").isNotNull())
                .and(col("usd_pledged_real").isNotNull())
                .and(col("usd_goal_real").isNotNull())
        );
        List<KickStarter> rowList = rows.orderBy(col("usd_pledged_real").desc()).limit(100).collectAsList();
        //RelationalGroupedDataset groupedDataset = dataset.groupBy(col("main_category"));

        //List<Row> rowList = rows.orderBy(col("usd_pledged_real").desc()).limit(100).collectAsList();

        /*List<KickStarter> kickStarters = rowList.stream().map(new Function<Row, KickStarter>() {
            @Override
            public KickStarter apply(Row row) {
                //System.out.println("+++++++++++++++++++ROW++++++++++++++===");
                //System.out.println(row);

                return new KickStarter(row.getInt(0),
                        row.getString(1),
                        row.getString(2),
                        row.getString(3),
                        row.getString(4),
                        row.getString(5),
                        row.getDouble(6),
                        row.getString(7),
                        row.getDouble(8),
                        row.getString(9),
                        row.getInt(10),
                        row.getString(11),
                        row.getDouble(12),
                        row.getDouble(13),
                        row.getDouble(14)
                );
            }
        }).collect(Collectors.toList());*/
        //return rows;
        return rowList;
    }


}

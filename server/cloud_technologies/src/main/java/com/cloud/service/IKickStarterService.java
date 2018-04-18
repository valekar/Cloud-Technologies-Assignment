package com.cloud.service;

import com.cloud.ViewModel.ProjectVM;
import com.cloud.model.KickStarter;

import java.util.List;

public interface IKickStarterService {
    void test();

     List<KickStarter> findProjects(ProjectVM projectVM);
}

import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { PagesComponent } from './pages.component';
import {TopProjectsComponent} from './project/components/top-projects/top-projects.component';
import {TotalPledgeComponent} from './project/components/total-pledge/total-pledge.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path:'',
      component:TopProjectsComponent
    },
    {
      path:'total/pledge',
      component:TotalPledgeComponent
    }

],

}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}

import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { PagesComponent } from './pages.component';
import {TopProjectsComponent} from './project/components/top-projects/top-projects.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path:'',
      component:TopProjectsComponent
    }

],

}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}

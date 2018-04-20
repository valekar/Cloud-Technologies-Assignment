import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ThemeModule } from '../../@theme/theme.module';
import { TopProjectsComponent } from './components/top-projects/top-projects.component';
import {SlimLoadingBarModule} from 'ng2-slim-loading-bar';

@NgModule({
  imports: [
    CommonModule,
    ThemeModule,
    SlimLoadingBarModule.forRoot()
  ],
  declarations: [TopProjectsComponent]
})
export class ProjectModule { }

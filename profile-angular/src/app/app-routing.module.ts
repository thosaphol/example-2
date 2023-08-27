import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListProfileComponent } from './list/list-profile/list-profile.component';

const routes: Routes = [
  {
    path:"profiles",component:ListProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

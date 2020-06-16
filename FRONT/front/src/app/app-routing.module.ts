import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PravljenjeAgenataComponent } from './pravljenje-agenata/pravljenje-agenata.component';
import { SearchComponentComponent } from './search-component/search-component.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path: "new-agent", component: PravljenjeAgenataComponent},
  {path : "search", component : SearchComponentComponent},
  {path : "",component : HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule   } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FetchItemsComponent } from './fetch-items/fetch-items.component';
import { FetchProductsComponent } from './fetch-products/fetch-products.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import { Routes, RouterModule, Router} from "@angular/router";
import { CartItemsComponent } from './cart-items/cart-items.component';
let routeConfig : Routes =[
  // {path:'', component: WelcomeComponent},
  {path:'products/:id',component: FetchProductsComponent},
  {path:'cart',component: CartItemsComponent},
  {path:'customer',component: CustomerFormComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    FetchItemsComponent,
    FetchProductsComponent,
    WelcomeComponent,
    CustomerFormComponent,
    CartItemsComponent
  ],
  imports: [
    BrowserModule,FormsModule,ReactiveFormsModule,HttpClientModule,
    RouterModule.forRoot(routeConfig)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

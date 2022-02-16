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
import { PaymentServiceComponent } from './payment-service/payment-service.component';

let routeConfig : Routes =[
   {path:'welcome', component: WelcomeComponent},
  {path:'products/:id',component: FetchProductsComponent},
  {path:'cart',component: CartItemsComponent},
  {path:'customer',component: CustomerFormComponent},
  {path:'cart/:product',component:CartItemsComponent}
  // {path:'payment',component:PaymentServiceComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    FetchItemsComponent,
    FetchProductsComponent,
    WelcomeComponent,
    CustomerFormComponent,
    CartItemsComponent,
    PaymentServiceComponent
  ],
  imports: [
    BrowserModule,FormsModule,ReactiveFormsModule,HttpClientModule,
    RouterModule.forRoot(routeConfig)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-fetch-products',
  templateUrl: './fetch-products.component.html',
  styleUrls: ['./fetch-products.component.css']
})
export class FetchProductsComponent implements OnInit {

    id:any;
    res : any=undefined;
    itemId: number = 0;
 

  productArray: any = [{}];
  
    products: any = undefined;
    msg: boolean = false;
    tab: boolean = false;

  constructor(private _productService:ProductService,
    private _builder:FormBuilder,
    private _actRoute: ActivatedRoute, private _route:Router) { 
   this._actRoute.params.subscribe((p:Params)=>{
     this.id = p['id'];
     console.log(this.id);
   this._productService.fetchEmployeeById(this.id).subscribe(data=>{
      console.log(data);
      this.products=data;
   },err=>{
     console.log(err)
   })
    });
  }

  ngOnInit(): void {
   
  }

  // product=this._builder.group({
  //   id:[]
  // })

  // handleSubmit() :void {
  //   let id=this.product.controls['id'].value;

  //   this._productService.fetchEmployeeById(id).subscribe(data=>{
  //      console.log(data);
  //   },err=>{
  //     console.log(err)
  //   })

  // }

  handleTest(itemId: any): void {
    console.log(itemId);
    this.itemId = itemId;
    this._productService.fetchEmployeeById(itemId).subscribe(data => {
      console.log(data);
      this.products = data;
      this.msg = true;
      this.tab = true;
      if (this.products == 0) {
        console.log('empty json')
      }
    }, err => {
      console.log(err)
    })
    console.log(itemId);
  }

  isChecked = false;
  checkuncheckall() {
    if (this.isChecked == true) {
      this.isChecked = false;
    }
    else {
      this.isChecked = true;
    }

  }

   product = {}

  handleCart(productName: string, price: number, id: number): void {
  
    this.product = {
      'productName': productName,
      'price': price,
      'id': id
    };

    console.log(this.product)
    const exists = this.productArray.filter((f: any) =>
      f.productName === this.product
    );
    if (exists.length <= 0) {
      console.log('insert:' + JSON.stringify(this.product));
      //this._router.navigate(['/cart',id,productName,price]);
      this._route.navigate(['/cart',JSON.stringify(this.product)]);
    } else {
      console.log('delete:' + JSON.stringify(this.product));
      //delete this.productArray[this.product];
    }

  }

}

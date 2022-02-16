import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { Items } from '../Items';
import { DataService } from '../data.service';

@Component({
  selector: 'app-fetch-products',
  templateUrl: './fetch-products.component.html',
  styleUrls: ['./fetch-products.component.css']
})
export class FetchProductsComponent implements OnInit {

  id: any;
  res: any = undefined;
  itemId: number = 0;




  productArray: any = [{}];

  products: any = undefined;
  msg: boolean = false;
  tab: boolean = false;

  constructor(private _productService: ProductService,
    private _builder: FormBuilder,
    private _actRoute: ActivatedRoute, private _route: Router, private _dataService: DataService) {
    this._actRoute.params.subscribe((p: Params) => {
      this.id = p['id'];
      console.log(this.id);
      this._productService.fetchEmployeeById(this.id).subscribe(data => {
        console.log(data);
        this.products = data;
      }, err => {
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

  items: Items[] = [];

  handleCart(productName: string, price: number, id: number): void {

    let item: any;
    item = new Items(id, productName, price);
    this.items.push(item)
  }


  additems() {
    console.log(this.items);
    this._dataService.setData(this.items);
    this._route.navigateByUrl('/cart')
  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ItemService } from '../item.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-fetch-items',
  templateUrl: './fetch-items.component.html',
  styleUrls: ['./fetch-items.component.css']
})
export class FetchItemsComponent implements OnInit {

  constructor(private _itemService: ItemService, private _builder:FormBuilder,
    private _router:Router,private _productService: ProductService) { }

  ngOnInit(): void {
  }

  details=this._builder.group({
    productName : [''], price : ['']
  })

  
  itemId: number = 0;
  res: any = undefined;
  products: any = undefined;
  msg: boolean = false;
  tab: boolean = false;

  handleSubmit(): void {

    this._itemService.fetchItems().subscribe(data => {

      this.res = data;
      console.log(data);
    }, err => {
      console.log(err);
    })

  }

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

  handleCart() : void {

    console.log(this.details);
  }

 
}

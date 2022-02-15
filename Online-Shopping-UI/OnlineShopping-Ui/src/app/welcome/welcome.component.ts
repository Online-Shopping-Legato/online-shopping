import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ItemService } from '../item.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private _itemService:ItemService,private _builder:FormBuilder,
    private _productService: ProductService) { }

  res : any=undefined;
  itemId: number = 0;

  products: any = undefined;
  msg: boolean = false;
  tab: boolean = false;

  ngOnInit(): void {
    this._itemService.fetchItems().subscribe(data=>{
      this.res=data;
      console.log(data);
    },err=>{
      console.log(err);
    })
  }

  data =this._builder.group({
    id:['']
  });

  getProducts():void{
    //let id= this.data.controls['id'].value;
    console.log('products ');
  }


}

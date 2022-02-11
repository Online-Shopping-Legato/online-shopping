import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-fetch-products',
  templateUrl: './fetch-products.component.html',
  styleUrls: ['./fetch-products.component.css']
})
export class FetchProductsComponent implements OnInit {

  constructor(private _productService:ProductService,private _builder:FormBuilder) { }

  ngOnInit(): void {
  }

  product=this._builder.group({
    id:[]
  })

  handleSubmit() :void {
    let id=this.product.controls['id'].value;

    this._productService.fetchEmployeeById(id).subscribe(data=>{
       console.log(data);
    },err=>{
      console.log(err)
    })

  }

}

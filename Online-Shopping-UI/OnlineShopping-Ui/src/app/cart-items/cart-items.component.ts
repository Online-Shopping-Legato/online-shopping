import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart-items',
  templateUrl: './cart-items.component.html',
  styleUrls: ['./cart-items.component.css']
})
export class CartItemsComponent implements OnInit {

  cartItems = [
    {id:1,name:'Iphone',price:200},
    {id:2,name:'samsung',price:100},
    {id:3,name:'google',price:300},
  ];
  constructor() { }

  ngOnInit(): void {
  }

}

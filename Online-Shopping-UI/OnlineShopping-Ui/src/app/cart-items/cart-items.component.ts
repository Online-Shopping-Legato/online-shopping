import { Component, OnInit } from '@angular/core';
import { BehaviourSubject } from 'rxjs';
import { ProductService } from '../product.service';
import { ActivatedRoute } from  '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-cart-items',
  templateUrl: './cart-items.component.html',
  styleUrls: ['./cart-items.component.css']
})
export class CartItemsComponent implements OnInit {
  cartDataList:any =[];
  productList=new BehaviourSubject<any>([]);

  cartItems = [
    {id:1,name:'Iphone',price:200},
    {id:2,name:'samsung',price:100},
    {id:3,name:'google',price:300},
  ];
  constructor() { }
    private activatedRoute: ActivatedRoute,
    private productService: ProductService

  getProduct(){
    return this.productList.asObservable();
  }
  setProduct(product:any){
    this.cartDataList.push(...product);
    this.productList.next(product)
  }

  addItem(product:any){
    this.cartDataList.push(product);
    this.productList.next(this.cartDataList);
    this.getTotal();
  }

  getTotal(){
    let grandTotal =0;
    this.cartDataList.map((a:any)=>{
      grandTotal += a.total;
    })
  }

  removeAllItem(){
    this.cartDataList =[];
    this.productList.next(this.cartDataList);
  }

  ngOnInit(): void {
       this.activatedRoute.params.subscribe(params =>{
         var id = params['id'];
         if (id) {
           var itemservice: ItemService = {
                productService: this.productservice.find(id),
                quantity: 1
           };
           if(localStorage.getItem('cart')==null){
             let cart: any = [];
             cart.push(JSON.stringify(item));
             let index: number = -1;
             for(var i =0; i<cart.length;i++){
               let itemservice: ItemService = JSON.parse(cart[i]);
               if(itemservice.productList.id ==id){
                 index = i;
                 break;
               }
             }
             if(index == -1){
               cart.push(JSON.stringify(itemservice));
               localStorage.setItem('cart',JSON.stringify(cart));
             }
             else{
               let itemservice: ItemService = JSON.parse(cart[index]);
                itemservice.quantity +=1;
                cart[index] = JSON.stringify(itemservice);
                localStorage.setItem("cart",JSON.stringify(cart));
               }
             }
          
           }
         }
       })
  }

}

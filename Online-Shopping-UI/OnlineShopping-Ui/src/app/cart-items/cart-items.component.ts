import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-cart-items',
  templateUrl: './cart-items.component.html',
  styleUrls: ['./cart-items.component.css']
})
export class CartItemsComponent implements OnInit {

  cartItems = [{}];
  res: any;
  constructor(private _activateRoute: ActivatedRoute, private _dataService: DataService) {
    this.cartItems = this._dataService.getData();
    console.log(this.cartItems);
  }

  ngOnInit(): void {
    this._activateRoute.params.subscribe((p: Params) => {
      this.res = p['items'];
      //this.cartItems.push(this.res[0]);
      // console.log(this.res);
    })


  }

}

import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-fetch-items',
  templateUrl: './fetch-items.component.html',
  styleUrls: ['./fetch-items.component.css']
})
export class FetchItemsComponent implements OnInit {

  constructor(private _itemService:ItemService) { }

  ngOnInit(): void {
  }

  res : any=undefined;

  handleSubmit(): void {
    
    this._itemService.fetchItems().subscribe(data=>{

      this.res=data;
      console.log(data);
    },err=>{
      console.log(err);
    })

  }

}

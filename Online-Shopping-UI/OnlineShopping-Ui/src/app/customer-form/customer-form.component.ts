import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  constructor(private _builder: FormBuilder,private _service: ProductService) { }

  ngOnInit(): void {
  }

  customer = this._builder.group({
    customername : ['', Validators.compose([Validators.required])],
    customerpassword : ['', Validators.compose([Validators.required])],
    accountnumber : ['', Validators.compose([Validators.required])],
    debitcardnumber:['', Validators.compose([Validators.required])],
    address: this._builder.group({
      streetname: ['', Validators.compose([Validators.required])],
      city: ['', Validators.compose([Validators.required])],
      state: ['', Validators.compose([Validators.required])],
      pin: ['', Validators.compose([Validators.required])],
  })
}
   );



  errMsg:any=undefined;

  success:any=undefined;

  handleSubmit(): void {
    this._service.storeCustomer(this.customer.value).subscribe(response=>{
      console.log(response.success);
      this.success=response.success;
      this.customer.reset();
    },err => {
      this.errMsg = err.error.error;
    })
  }
}

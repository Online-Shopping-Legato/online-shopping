export class Items{

    public productId:number;
    public productName:string;
    public price :number;

    constructor(id:number,name:string,price:number){
      this.productId=id;
      this.productName=name;
      this.price=price;
    }

}
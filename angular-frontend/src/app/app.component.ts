import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
@Injectable()
export class AppComponent {
  netSub: Subscription =new Subscription;
  constructor(private http: HttpClient) { }



ngOnInit(){
  console.log('hi')
  this.getService()
}
responseData:any={}
responseCopy:any[]=[]

updateProductName:string=''
updateProductId:string=''
updateProductType:string=''
updateProductCategory:string=''
updateProductPrice:string=''

showDiv=false;
IsUpdateOn=false
showAddDiv=false;

getService(){
  this.http.get('http://localhost:8080/api/v1/get-products').subscribe(res=>{
    console.log(res)
    this.responseData = res;
    this.responseCopy = this.responseData
    console.log( this.responseCopy)

  })
}

updateBtn(i:any){
  this.showDiv = true;
  this.IsUpdateOn=true
  const body={
    id: this.updateProductId = this.responseData[i].productId,
    productName : this.updateProductName = this.responseData[i].name,
    productType :  this.updateProductType = this.responseData[i].productType,
    productPrice : this.updateProductPrice = this.responseData[i].basePrice,
    productCategory : this.updateProductCategory = this.responseData[i].category,
  }
}

updateData(){
  const reqBody={
    id: this.updateProductId ,
    productName : this.updateProductName ,
    productType :  this.updateProductType ,
    productPrice : this.updateProductPrice,
    productCategory : {
        id: 1,
        category : "Electronics",
        discount : "15",
        gst : "18",
        deliveryCharge : "350"
    }
  }
  // this.http.put(reqBody.id, reqBody.productCategory, reqBody.productName,reqBody.productPrice,reqBody.productType).subscribe(res=>{
  this.http.put('http://localhost:8080/api/v1/update-product',reqBody).subscribe(res=>{
console.log(res)

  })
}
addBtn(){
  this.showAddDiv=true
}

addData(){
  const reqBody={
    productName : this.updateProductName ,
      productType :  this.updateProductType ,
      productPrice : this.updateProductPrice,
      productCategory : {
        category : "Electronics",
              discount : "15",
              gst : "18",
              deliveryCharge : "350"
    }
}
  this.http.post('http://localhost:8080/api/v1/add-product',reqBody).subscribe(res=>{
console.log(res)

  })
}

deleteData(i:any){
  this.responseData.splice(i,1)
  console.log('deleted')
}



}

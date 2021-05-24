import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CalculationService {

  private baseUrl = 'http://localhost:8182/priceEngine';

  constructor(private http: HttpClient) { }

  calculatePrice(productData: { productId: string; carton: string; sUnits: string; }) {
    return this.http.get(this.baseUrl+'/calculatePrice/'+ productData.productId+"/"+productData.carton+"/"+productData.sUnits);
  }

  




  
  



  
}

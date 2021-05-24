import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CalculationService } from '../calculation.service';


@Component({
  selector: 'app-calculation',
  templateUrl: './calculation.component.html',
  styleUrls: ['./calculation.component.css']
})
export class CalculationComponent implements OnInit {

  submitted = false;
  data: any;
  msg: string;
  isShowDiv: boolean;

  constructor(private calculationService: CalculationService) {
    this.calculationService = calculationService;

  }

  ngOnInit(): void {
  }

  product = {
    productId: "",
    carton: "",
    sUnits: ""
  }

  onSubmit(formdata: NgForm) {
    let productData = {
      productId: this.product.productId,
      carton: this.product.carton,
      sUnits: this.product.sUnits
    }
    console.log(productData)

    this.calculationService.calculatePrice(productData)
      .subscribe(
        response => {
          console.log(response);
          this.data = response;

          this.submitted = false;
        },
        error => {
          console.log(error);
          return;
        }
      )

  }
  clickEvent() {
    this.msg = 'The Total price is  ';
    return this.msg;
  }
}





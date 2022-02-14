import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'paymentService'
})
export class PaymentServicePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}

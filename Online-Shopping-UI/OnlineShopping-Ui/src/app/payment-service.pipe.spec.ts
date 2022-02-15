import { PaymentServicePipe } from './payment-service.pipe';

describe('PaymentServicePipe', () => {
  it('create an instance', () => {
    const pipe = new PaymentServicePipe();
    expect(pipe).toBeTruthy();
  });
});

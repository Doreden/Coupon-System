import axios from "axios";
import CouponModel from "../Models/CouponModel";
import { CustomerModel } from "../Models/UserModel";
import { adminStore } from "../Redux/AdminState";
import { authStore } from "../Redux/AuthState";
import { buyCouponsAction, customersStore, fetchCouponsAction } from "../Redux/CustomersState";
import appConfig from "../Utils/Config";

class CustomersService {
  //--------------------------------------------------------------------------------
  //Customer Service Methods:
  //--------------------------------------------------------------------------------
  //--------------------------------------------------------------------------------
  // Get The Customer Coupons List By Given ID:
  //--------------------------------------------------------------------------------
  public async fetchMyCoupons(): Promise<CouponModel[]> {
    let coupons = customersStore.getState().coupons;

    if (coupons.length === 0) {
      const response = await axios.get<CouponModel[]>(
        appConfig.customersMyCouponsUrl + authStore.getState().user.id
      );
      coupons = response.data;
      console.log(coupons);
      customersStore.dispatch(fetchCouponsAction(coupons));
    }
    return coupons;

  }

  //--------------------------------------------------------------------------------
  // Get All Coupons List By Given ID:
  //--------------------------------------------------------------------------------
  public async fetchOtherCoupons(): Promise<CouponModel[]> {
    let coupons = customersStore.getState().coupons;
    const response = await axios.get<CouponModel[]>(
      appConfig.customersOtherCouponsUrl
    );
    coupons = response.data;
    console.log(coupons);
    return coupons;
  }

  //--------------------------------------------------------------------------------
  // Get Customer Details:
  //--------------------------------------------------------------------------------
  public async getCustomerDetails(id: number): Promise<CustomerModel> {
    let customers = adminStore.getState().customers;
    const response = await axios.get<CustomerModel>(
      appConfig.customerDetailsUrl + id
    );
    const customer = response.data;
    return customer;
  }



  //--------------------------------------------------------------------------------
  // Buy Coupon:
  //--------------------------------------------------------------------------------
  public async buyCoupon(couponId: number): Promise<CouponModel> {
    let coupons = customersStore.getState().coupons;
    const response = await axios.post<CouponModel>(
      appConfig.customersBuyCouponUrl +
        authStore.getState().user.id +
        "/" +
        couponId
    );
    const coupon = response.data;
    customersStore.dispatch(buyCouponsAction(coupon));
    return coupon;
  }
}

const customersService = new CustomersService();

export default customersService;

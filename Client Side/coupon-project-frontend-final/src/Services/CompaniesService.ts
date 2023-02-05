import axios from "axios";
import CouponModel from "../Models/CouponModel";
import { authStore } from "../Redux/AuthState";
import {
  companiesReducer,
  companiesStore,
  createCouponAction,
  deleteCouponAction,
  fetchCompanyCouponsAction,
  updateCouponAction,
} from "../Redux/CompanyState";
import {
  buyCouponsAction,
  customersStore,
  fetchCouponsAction,
} from "../Redux/CustomersState";
import appConfig from "../Utils/Config";

class CompaniesService {
  //--------------------------------------------------------------------------------
  //Companies Service Methods:
  //--------------------------------------------------------------------------------
  //--------------------------------------------------------------------------------
  // Get The Company Coupons List By Company ID:
  //--------------------------------------------------------------------------------
  public async fetchCompanyCoupons(): Promise<CouponModel[]> {
    let coupons = companiesStore.getState().coupons;
    if (coupons.length === 0) {
      const response = await axios.get<CouponModel[]>(
        appConfig.companyCouponsUrl + authStore.getState().user.id
      );
      coupons = response.data;
      console.log(coupons);
      companiesStore.dispatch(fetchCompanyCouponsAction(coupons));
    }
    return coupons;
  }

  //--------------------------------------------------------------------------------
  // Get One Company Coupon By Coupon ID:
  //--------------------------------------------------------------------------------
  public async getOneCoupon(id: number): Promise<CouponModel> {
    let coupons = companiesStore.getState().coupons;
    const response = await axios.get<CouponModel>(
      appConfig.companyGetOneCouponUrl + id
    );
    const coupon = response.data;
    console.log("1 Coupon brought Details: " + coupon.id);
    return coupon;
  }



  // --------------------------------------------------------------------------------
  // Company Create Coupon Methods:
  // --------------------------------------------------------------------------------
  public async createCoupon(coupon: CouponModel): Promise<CouponModel> {

    coupon.companyId = authStore.getState().user.id;

    const response = await axios.post<CouponModel>(
      appConfig.companyCreateCouponUrl,
      coupon
    );

    const createdCoupon = response.data;

    console.log(createdCoupon);

    companiesStore.dispatch(createCouponAction(createdCoupon));

    return createdCoupon;
  }

  // --------------------------------------------------------------------------------
  // Company Update Coupon Methods:
  // --------------------------------------------------------------------------------
  public async updateCoupon(coupon: CouponModel): Promise<CouponModel> {
    coupon.companyId = authStore.getState().user.id;
    const response = await axios.put<CouponModel>(
      appConfig.companyUpdateCouponUrl,
      coupon
    );

    const updatedCoupon = response.data;

    companiesStore.dispatch(updateCouponAction(updatedCoupon));

    return updatedCoupon;
  }

  // --------------------------------------------------------------------------------
  // Company Delete Coupon Methods:
  // --------------------------------------------------------------------------------

  public async deleteCoupon(id: number): Promise<void> {
        let coupons = companiesStore.getState().coupons;
    /// Delete in backend:
    await axios.delete(appConfig.companyDeleteCouponUrl + id);
    // Delete in redux global state:
    companiesStore.dispatch(deleteCouponAction(id));
  }
    
}

const companiesService = new CompaniesService();

export default companiesService;

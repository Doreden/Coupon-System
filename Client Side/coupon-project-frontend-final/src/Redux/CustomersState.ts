import { createStore } from "redux";
import CouponModel from "../Models/CouponModel";
import { CustomerModel } from "../Models/UserModel";

//----------------------------------------------------------------//
// 1 - State:
//----------------------------------------------------------------//
export class CustomersState {
  public coupons: CouponModel[] = [];
  public customers: CustomerModel[] = [];
}
//----------------------------------------------------------------//
// 2 - Action Type:
//----------------------------------------------------------------//
export enum CustomersActionTypes {
  FetchCoupons = "FetchCoupons",
  BuyCoupons = "BuyCoupons",
  FetchDetails = "FetchDetails",
}
//----------------------------------------------------------------//
// 3 - Actions Interface:
//----------------------------------------------------------------//
export interface CustomersAction {
  type: CustomersActionTypes;
  payload: any;
}
//----------------------------------------------------------------//
// 4 - Actions Creators:
//----------------------------------------------------------------//
export function fetchCouponsAction(coupons: CouponModel[]): CustomersAction {
  return { type: CustomersActionTypes.FetchCoupons, payload: coupons };
}

export function FetchDetailsAction(customer: CustomerModel[]): CustomersAction {
  return { type: CustomersActionTypes.FetchDetails, payload: customer };
}

export function buyCouponsAction(coupons: CouponModel): CustomersAction {
  return { type: CustomersActionTypes.BuyCoupons, payload: coupons };
}

//----------------------------------------------------------------//
// 5 - Reducer:
//----------------------------------------------------------------//
export function customersReducer(
  currentState = new CustomersState(),
  action: CustomersAction
): CustomersState {
  const newState = { ...currentState };
  switch (action.type) {
    // Get Coupons
    case CustomersActionTypes.FetchCoupons:
      newState.coupons = action.payload;
      break;

    // Get Details
    case CustomersActionTypes.FetchDetails:
      newState.customers = action.payload;
      break;

    // Buy Coupon
    case CustomersActionTypes.BuyCoupons:
      newState.coupons.push(action.payload);
      break;
  }

  return newState;
}
//----------------------------------------------------------------//
// 6 - Store:
//----------------------------------------------------------------//
export const customersStore = createStore(customersReducer);
//----------------------------------------------------------------//

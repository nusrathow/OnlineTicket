import {Bus} from "../bus/bus";

export class Ticket {
  id!:number;
  busId!:Bus;
  seat!:string;
  userName!:string;
  email!:string;
  mobileNo!:string;
}

import {Bus} from "./bus/bus";
import {Seat} from "./seat/seat";
import { Journey_Route} from "./route";

export class Journey {
  bus!:Bus;
  seats!:seat[];
  fare!:number;
  journey_route!:Journey_Route
}

export interface seat {
  seat:string
}

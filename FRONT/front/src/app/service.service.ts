import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from './../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  createNewAgent(type: any, name: any) {
    return this.http.put(`${environment.url}agents/running/${type}/${name}`, {

    })
      .pipe(
        map((res: any) => {
          const data = res;
          console.log(data);
          return data;
        }),
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      )
  }
  search(timA: any, timB: any) {
    return this.http.get(`${environment.url}agents/getWinningTeam/${timA}/${timB}`).pipe(
      map((res: any) => {
        const data = res;
        console.log(data);
        return data;
      }),
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    )
    
  }
  getRunningAgents() {
    return this.http.get(`${environment.url}agents/running`).pipe(
      map((res: any) => {
        const data = res;
        console.log(data);
        return data;
      }),
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    )
  }
  getAgentClasses() {
    return this.http.get(`${environment.url}agents/classes`).pipe(
      map((res: any) => {
        const data = res;
        console.log(data);
        return data;
      }),
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    )
  }
}

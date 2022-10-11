import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  URL = environment.API_URL;
  status = '';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  public getAll(path: string): Observable<any> {
    return this.http.get<any>(`https://634069cae44b83bc73d00a93.mockapi.io/api/task`);
  }

  public create(data: any): Observable<any> {
    return this.http.post<any>(`https://634069cae44b83bc73d00a93.mockapi.io/api/task` , data, this.httpOptions);
  }

  public getById(path: string, id: number): Observable<any> {
    return this.http.get<any>(`https://634069cae44b83bc73d00a93.mockapi.io/api/task/${id}`, { observe: 'response' });
  }

  public deleteById(path: string, id: number) {
    this.http.delete(`https://634069cae44b83bc73d00a93.mockapi.io/api/task/${id}`)
            .subscribe(() => this.status = 'Delete successful');
  }

  public updateById(data: any, path: string, id: number): Observable<any> {
    return this.http.put<any>(`https://634069cae44b83bc73d00a93.mockapi.io/api/${path}/${id}`, data, this.httpOptions);
  }

}

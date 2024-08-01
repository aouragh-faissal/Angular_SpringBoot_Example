import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  constructor(private http: HttpClient) { }
  private url = 'http://192.168.1.11:8080/';



  CreateNewHero(formdata : any){
    return this.http.post(this.url + 'hero/create' , formdata);

  }

  getAllHeros(){
    return this.http.get(this.url + 'hero/list' );
  }

  deleteHero(id: any){
    return this.http.delete(this.url + 'hero/deletehero/' + id );
  }

  getById(id: any){
    return this.http.get(this.url + 'hero/gethero/' + id );
  }

  update(id: any, hero: any){
    return this.http.put(this.url + 'hero/updatehero/' + id , hero);
  }
}

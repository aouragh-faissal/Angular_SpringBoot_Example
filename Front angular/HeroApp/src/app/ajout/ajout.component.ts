import { Component } from '@angular/core';
import { SharedService } from '../shared.service';
import { log } from 'console';

@Component({
  selector: 'app-ajout',
  templateUrl: './ajout.component.html',
  styleUrl: './ajout.component.css'
})
export class AjoutComponent {

  hero = {
    name: '',
    power: 0,
  };

image : any ;

selectImage(e: any){
  this.image = e.target.files[0];
  console.log(this.image);
}




  ajout()
  {
    let formdata = new FormData();
    formdata.append('name' , this.hero.name);
    formdata.append('power' , this.hero.power.toString());
    formdata.append('image' , this.image);


    this._shared.CreateNewHero(formdata).subscribe(
      res=>{
        this.hero = {
          name: '',
          power: 0,
        };
        console.log(res);
      },
      err=>{
        console.log(err);
      }
    );
  }

  constructor(public _shared : SharedService){
  }

}


interface IUser{
    id:number;
    name:string;
    status:boolean;
}

function Decorator(constructorFunction: Function){
    console.log("decorator sebelum class")
}

@Decorator
class Perkenalan implements IUser{
    id:number;
    name: string;
    status: boolean;

    constructor(id:number, name:string, status:boolean){
        this.id = id;
        this.name = name;
        this.status = status;
    }

    showData(){
        console.log("id : " + this.id); 
        console.log("name : " + this.name);
        console.log("status : " + this.status); 5
        // return "test";
    }


}

function getArray(item : number[]) {
    item.forEach(element => {
        console.log(element)
    });
}

let perkenalan = new Perkenalan(1, "firman", true);

perkenalan.showData();

getArray([100,22,33,44])

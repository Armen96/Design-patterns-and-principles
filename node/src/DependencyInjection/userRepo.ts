export interface IUserRepo { // Exported
    getUsers(): Promise<any[]>
}

class UserRepo implements IUserRepo { // Not exported
    constructor () {}

    getUsers (): Promise<any[]> {
        return new Promise(resolve => {
            const data = [{id: 1, name: 'John'}, {id: 2, name: 'Peter'}];
            resolve(data);
        });
    }
}

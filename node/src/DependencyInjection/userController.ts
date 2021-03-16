import { IUserRepo } from './userRepo';

/**
 * @class UserController
 * @desc Responsible for handling API requests for the
 **/

class UserController {
    private userRepo: IUserRepo;

    constructor (userRepo: IUserRepo) {
        this.userRepo = userRepo;
    }

    async handleGetUsers (req, res): Promise<void> {
        const users = await this.userRepo.getUsers();
        return res.status(200).json({ users });
    }
}

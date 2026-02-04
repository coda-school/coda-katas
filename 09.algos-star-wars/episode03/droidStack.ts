export class DroidStack<T> {
    private readonly stack: T[];

    constructor() {
        this.stack = [];
    }

    push = (droid: T) => this.stack.push(droid);
    pop = (): T | undefined => this.stack.pop();
}
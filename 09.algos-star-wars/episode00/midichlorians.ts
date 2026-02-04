export type Jedi = { name: string; midichlorians: number }

export function totalMidichlorians(jedis: Jedi[]): number {
    let midichlorians = 0;
    for (let i = 0; i < jedis.length; i++) {
        midichlorians += jedis[i].midichlorians;
    }
    return midichlorians;
}

export function totalMidichloriansWithForeach(jedis: Jedi[]): number {
    let midichlorians = 0;
    for (const jedi of jedis) {
        midichlorians += jedi.midichlorians;
    }
    return midichlorians;
}

export function totalMidichloriansWithReducer(jedis: Jedi[]): number {
    return jedis.reduce((midichlorians, jedi) => jedi.midichlorians + midichlorians, 0);
}
export type Jedi = { name: string; midichlorians: number }

export const totalMidichlorians = (jedis: Jedi[]): number => {
    let midichlorians = 0;
    for (let i = 0; i < jedis.length; i++) {
        midichlorians += jedis[i].midichlorians;
    }
    return midichlorians;
};

export const totalMidichloriansWithForeach = (jedis: Jedi[]): number => {
    let midichlorians = 0;
    for (const jedi of jedis) {
        midichlorians += jedi.midichlorians;
    }
    return midichlorians;
};

export const totalMidichloriansRecursively = (jedis: Jedi[]): number => {
    const midichloriansRecursively = (remainingJedis: Jedi[]): number => {
        if (remainingJedis.length == 0) return 0;
        return remainingJedis[0].midichlorians + midichloriansRecursively(remainingJedis.slice(1));
    };
    return midichloriansRecursively(jedis);
};

export const totalMidichloriansRecursivelyWithIndex = (jedis: Jedi[]): number => {
    const midichloriansRecursively = (jedis: Jedi[], currentIndex: number): number => {
        if (currentIndex == jedis.length) return 0;
        return jedis[currentIndex].midichlorians + midichloriansRecursively(jedis, currentIndex + 1);
    };
    return midichloriansRecursively(jedis, 0);
};

export const totalMidichloriansWithReducer = (jedis: Jedi[]): number =>
    jedis.reduce((midichlorians, jedi) => jedi.midichlorians + midichlorians, 0);

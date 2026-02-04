const nextFor = (term: string): string => {
    let result = "";
    let i = 0;

    while (i < term.length) {
        const currentDigit = term[i];
        let count = 1;

        while (i + count < term.length && term[i + count] === currentDigit)
            count++;

        // Ajouter "count + digit" au résultat
        result += count.toString() + currentDigit;
        i += count;
    }

    return result;
};

export function droidTransmission(n: number): string {
    if (n === 1) return "1";

    let current = "1";
    for (let i = 2; i <= n; i++) {
        current = nextFor(current);
    }
    return current;
}

export const droidTransmissionWithReducer = (n: number): string =>
    [...Array(n - 1)].reduce((current) => nextFor(current), "1");
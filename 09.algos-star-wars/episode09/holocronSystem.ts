export type HolocronSymbol = '⚫' | '⚪' | '0' | '⭐' | 'Y';

const symbols: Record<HolocronSymbol, number> = {
    '⚫': -2,
    '⚪': -1,
    '0': 0,
    '⭐': 1,
    'Y': 2
};

export const hqsToDecimal = (gqs: string): number => {
    let sum = 0;
    const chars = [...gqs];

    for (let i = 0; i < chars.length; i++) {
        const symbol = chars[chars.length - 1 - i] as HolocronSymbol;
        sum += symbols[symbol] * Math.pow(5, i);
    }

    return sum;
};

export const hqsToDecimalWithReducer = (gqs: string): number =>
    [...gqs].reverse()
        .map(c => c as HolocronSymbol)
        .map((s, index) => symbols[s] * Math.pow(5, index))
        .reduce((sum, value) => sum + value, 0);
const outOfRange = (n: number) => n <= 0;

export const cloneSequence = (n: number): number[] => {
    if (outOfRange(n)) return [];
    if (n === 1) return [0];

    const sequence = [0, 1];
    for (let i = 2; i < n; i++) {
        const next = sequence[i - 1] + sequence[i - 2];
        sequence.push(next);
    }
    return sequence;
};

export const cloneSequenceWithSlice = (n: number): number[] => {
    if (outOfRange(n)) return [];

    const sequence = [0, 1];
    for (let i = 2; i < n; i++) {
        const next = sequence[i - 1] + sequence[i - 2];
        sequence.push(next);
    }
    return sequence.slice(0, n);
};
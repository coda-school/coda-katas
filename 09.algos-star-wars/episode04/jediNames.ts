export const uniqueJediNames = (names: string[]): string[] => Array.from(
    new Set(names)
);
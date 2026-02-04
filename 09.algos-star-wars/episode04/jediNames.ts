export function uniqueJediNames(names: string[]): string[] {
    return Array.from(
        new Set(names)
    );
}
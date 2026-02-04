export function isSithCode(code: string): boolean {
    const cleaned = code.toLowerCase().replace(/[^a-z0-9]/g, '');

    function isPalindromeRecursive(str: string): boolean {
        if (str.length <= 1) return true;

        return str[0] === str[str.length - 1]
            ? isPalindromeRecursive(str.slice(1, -1))
            : false;
    }

    return isPalindromeRecursive(cleaned);
}
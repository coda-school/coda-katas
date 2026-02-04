import { describe, it, expect } from 'vitest';
import {isSithCode} from "./sithCode";

describe('Episode 7: Le Code Sith', () => {
    it('detects palindrome codes', () => {
        expect(isSithCode('radar')).toBe(true);
        expect(isSithCode('kayak')).toBe(true);
        expect(isSithCode('level')).toBe(true);
    });

    it('detects non-palindrome codes', () => {
        expect(isSithCode('sith')).toBe(false);
        expect(isSithCode('empire')).toBe(false);
    });

    it('handles empty string', () => {
        expect(isSithCode('')).toBe(true);
    });

    it('handles single character', () => {
        expect(isSithCode('a')).toBe(true);
    });

    it('ignores spaces and case', () => {
        expect(isSithCode('A man a plan a canal Panama')).toBe(true);
        expect(isSithCode('Race Car')).toBe(true);
    });
});
import { useRef } from 'react';

type Fn = (...args: any) => any

export default <T extends Fn> (fn: T, delay: number = 300) => {
    const ref = useRef<NodeJS.Timeout | null>(null);
    return (...args: Parameters<T>) => {
        if (ref.current) clearTimeout(ref.current);
        ref.current = setTimeout(fn, delay, ...args);
    };
}

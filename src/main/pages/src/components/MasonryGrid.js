import React, { PropTypes, useRef, useState, useEffect } from 'react'
import { useTransition, animated as a, config } from 'react-spring'
import shuffle from 'lodash/shuffle'
import data from '../data/MasonryDataPic';
import ResizeObserver from 'resize-observer-polyfill';

const list = {
    boxSizing: 'border-box',
    position: 'relative',
    fontFamily: '-apple-system, BlinkMacSystemFont, avenir next, avenir, helvetica neue, helvetica, ubuntu, roboto, noto, segoe ui, arial, sans-serif',
    width: '100%',
    height: '100%',
};

const listDiv = {
    boxSizing: 'border-box',
    position: 'absolute',
    willChange: 'transform, width, height, opacity',
    padding: '15px',
};

const listDivDiv = {
    boxSizing: 'border-box',
    position: 'relative',
    backgroundSize: 'cover',
    backgroundPosition: 'center center',
    width: '100%',
    height: '100%',
    overflow: 'hidden',
    textTransform: 'uppercase',
    fontSize: '10px',
    lineHeight: '10px',
    borderRadius: '4px',
    boxShadow: '0px 10px 50px -10px rgba(0, 0, 0, 0.2)',
};

function useMedia(queries, values, defaultValue) {
    const match = () => values[queries.findIndex(q => matchMedia(q).matches)] || defaultValue;
    const [value, set] = useState(match);
    useEffect(() => {
        const handler = () => set(match);
        window.addEventListener('resize', handler);
        return () => window.removeEventListener(handler)
    }, []);
    return value
}

function useMeasure() {
    const ref = useRef();
    const [bounds, set] = useState({ left: 0, top: 0, width: 0, height: 0 });
    const [ro] = useState(() => new ResizeObserver(([entry]) => set(entry.contentRect)));
    useEffect(() => (ro.observe(ref.current), ro.disconnect), []);
    return [{ ref }, bounds]
}

function MasonryGrid() {
    const columns = useMedia(['(min-width: 1500px)', '(min-width: 1000px)', '(min-width: 600px)'], [5, 4, 3], 2);
    const [bind, { width }] = useMeasure();
    const [items, set] = useState(data);
    useEffect(() => void setInterval(() => set(shuffle), 2000), []);
    let heights = new Array(columns).fill(0); // Each column gets a height starting with zero
    let gridItems = items.map((child, i) => {
        const column = heights.indexOf(Math.min(...heights)); // Basic masonry-grid placing, puts tile into the smallest column using Math.min
        const xy = [(width / columns) * column, (heights[column] += child.height / 2) - child.height / 2] // X = container width / number of columns * column index, Y = it's just the height of the current column
        return { ...child, xy, width: width / columns, height: child.height / 2 }
    });

    // This turns gridItems into transitions, any addition, removal or change will be animated
    const transitions = useTransition(gridItems, item => item.css, {
        from: ({ xy, width, height }) => ({ xy, width, height, opacity: 0 }),
        enter: ({ xy, width, height }) => ({ xy, width, height, opacity: 1 }),
        update: ({ xy, width, height }) => ({ xy, width, height }),
        leave: { height: 0, opacity: 0 },
        config: { mass: 5, tension: 500, friction: 100 },
        trail: 25
    });

    return (
        <div {...bind} style={{ height: Math.max(...heights), ...list }}>
            {transitions.map(({ item, props: { xy, ...rest }, key }) => (
                <a.div key={key} style={{ transform: xy.interpolate((x, y) => `translate3d(${x}px,${y}px,0)`), ...rest, ...listDiv }}>
                    <div style={{ backgroundImage: item.css, ...listDivDiv }} />
                </a.div>
            ))}
        </div>
    )
}

export default MasonryGrid;
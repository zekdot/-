function nodeComp(node1, node2) {
    if(node1.dir && !node2.dir) {
        return -1;
    }
    if(node2.dir && !node1.dir) {
        return 1;
    }
    return node1.name.localeCompare(node2.name);
}
export {
    nodeComp
}
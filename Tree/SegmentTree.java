public class SegmentTree {
  int[] tree;
  int n;

  public SegmentTree(int[] arr) {
    n = arr.length;
    tree = new int[4 * n];
    build(arr, 1, 0, n - 1);
  }

  private void build(int[] arr, int node, int start, int end) {

    if (start == end)
      tree[node] = arr[start];
    else {
      int mid = (start + end) / 2;

      build(arr, 2 * node, start, mid);
      build(arr, 2 * node + 1, mid + 1, end);

      tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

  }

  // query

  public int query(int l, int r) {
    return queryUtil(1, 0, n - 1, l, r);

  }

  private int queryUtil(int node, int start, int end, int l, int r) {

    // no overlap

    if (r < start || end < l) {
      return 0;
    }

    // compete oeverlaps
    if (l <= start && end <= r) {
      return tree[node];

    }

    // partial overlap
    int mid = (start + end) / 2;
    int left = queryUtil(2 * node, start, mid, l, r);

    int right = queryUtil(2 * node + 1, mid + 1, end, l, r);

    return left + right;
  }

  // update

  public void update(int idx, int val) {
    updateUtil(1, 0, n - 1, idx, val);
  }

  private void updateUtil(int node, int start, int end, int idx, int val) {
    if (start == end) {
      tree[node] = val;
    } else {
      int mid = (start + end) / 2;

      if (idx <= mid) {
        updateUtil(2 * node, start, mid, idx, val);
      } else {
        updateUtil(2 * node + 1, mid + 1, end, idx, val);
      }

      tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
  }

  public static void main(String[] args) {

    int[] arr = { 1, 3, 5, 7, 9, 11 };
    SegmentTree st = new SegmentTree(arr);

    System.out.println(st.query(1, 3));

    st.update(1, 10);

    System.out.println(st.query(1, 3));

  }
}

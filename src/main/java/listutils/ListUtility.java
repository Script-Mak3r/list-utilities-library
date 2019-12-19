package listutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Library for generic list utilities
 *
 * @version 1.4.0
 */
public class ListUtility {

  private ListUtility(){}
  
  /**
   * Returns a new flattened List.
   * <p>
   * For every element that is an array or List, extract its elements into the new List. This is
   * repeated until the final output is a 1-dimensional List.
   * </p>
   * <p>
   * Note that, due to Java's implementation of generics, arrays of primitives will ultimately
   * result in a List containing an array.
   * </p>
   *
   * @param <T> Generic input class identifier
   * @param <R> Generic return class identifier
   * @param list Input list
   * @return Flattened list
   * @since 1.0.0
   */
  @SuppressWarnings({"unchecked", "SuspiciousToArrayCall"})
  public static <T, R> List<R> flatten(List<T> list) {
    if (list.isEmpty() || !(list.get(0) instanceof List<?> || list.get(0).getClass().isArray())) {
      return (List<R>) list;
    }
    if (list.get(0).getClass().isArray() && list.get(0).getClass().getComponentType().isPrimitive()) {
      if (list.get(0).getClass() == int[].class) { //In no particular order
        return (List<R>) flatten(list.toArray(new int[0][0]));
      }
      if (list.get(0).getClass() == byte[].class) {
        return (List<R>) flatten(list.toArray(new byte[0][0]));
      }
      if (list.get(0).getClass() == double[].class) {
        return (List<R>) flatten(list.toArray(new double[0][0]));
      }
      if (list.get(0).getClass() == boolean[].class) {
        return (List<R>) flatten(list.toArray(new boolean[0][0]));
      }
      if (list.get(0).getClass() == short[].class) {
        return (List<R>) flatten(list.toArray(new short[0][0]));
      }
      if (list.get(0).getClass() == long[].class) {
        return (List<R>) flatten(list.toArray(new long[0][0]));
      }
      if (list.get(0).getClass() == char[].class) {
        return (List<R>) flatten(list.toArray(new char[0][0]));
      }
      if (list.get(0).getClass() == float[].class) {
        return (List<R>) flatten(list.toArray(new float[0][0]));
      }
    }
    List<T> flat = new ArrayList<>();
    if (list.get(0) instanceof List<?>) {
      for (int i = 0; i < list.size(); i++) {
        for (int j = 0; j < ((List<T>) list.get(i)).size(); j++) {
          flat.add(((List<T>) list.get(i)).get(j));
        }
      }
    } else if (list.get(0).getClass().isArray()) {
      for (int i = 0; i < list.size(); i++) {
        flat.addAll(Arrays.asList((T[]) list.get(i)));
      }
    } else {
      throw new AssertionError("Should never happen");
    }
    return flatten(flat);
  }

  /**
   * Returns a new flattened List.
   * <p>
   * For every element that is an array or List, extract its elements into the new List. Recursion
   * is limited to {@code level} iterations.
   * </p>
   * <p>
   * Note that, due to Java's implementation of generics, arrays of primitives will ultimately
   * result in a List containing an array, given a high enough {@code level}.
   * </p>
   *
   * @param <T> Generic input class identifier
   * @param <R> Generic return class identifier
   * @param list Input list
   * @param level Level of recursion to flatten
   * @return Flattened list
   * @since 1.0.0
   */
  @SuppressWarnings({"unchecked", "SuspiciousToArrayCall"})
  public static <T, R> List<R> flatten(List<T> list, int level) {
    if (list.isEmpty() || !(list.get(0) instanceof List<?> || list.get(0).getClass().isArray())
        || level == 0) {
      return (List<R>) list;
    }
    if (list.get(0).getClass().isArray() && list.get(0).getClass().getComponentType().isPrimitive()) {
      if (list.get(0).getClass() == int[].class) { //In no particular order
        return (List<R>) flatten(list.toArray(new int[0][0]));
      }
      if (list.get(0).getClass() == byte[].class) {
        return (List<R>) flatten(list.toArray(new byte[0][0]));
      }
      if (list.get(0).getClass() == double[].class) {
        return (List<R>) flatten(list.toArray(new double[0][0]));
      }
      if (list.get(0).getClass() == boolean[].class) {
        return (List<R>) flatten(list.toArray(new boolean[0][0]));
      }
      if (list.get(0).getClass() == short[].class) {
        return (List<R>) flatten(list.toArray(new short[0][0]));
      }
      if (list.get(0).getClass() == long[].class) {
        return (List<R>) flatten(list.toArray(new long[0][0]));
      }
      if (list.get(0).getClass() == char[].class) {
        return (List<R>) flatten(list.toArray(new char[0][0]));
      }
      if (list.get(0).getClass() == float[].class) {
        return (List<R>) flatten(list.toArray(new float[0][0]));
      }
    }
    List<T> flat = new ArrayList<>();
    if (list.get(0) instanceof List<?>) {
      for (int i = 0; i < list.size(); i++) {
        for (int j = 0; j < ((List<T>) list.get(i)).size(); j++) {
          flat.add(((List<T>) list.get(i)).get(j));
        }
      }
    } else if (list.get(0).getClass().isArray()) {
      for (int i = 0; i < list.size(); i++) {
        flat.addAll(Arrays.asList((T[]) list.get(i)));
      }
    } else {
      throw new AssertionError("Should never happen");
    }
    return flatten(flat, level - 1);
  }

  /**
   * Returns a new flattened List.
   * <p>
   * For every element that is an array or List, extract its elements into the new List. This is
   * repeated until the final output is a 1-dimensional List.
   * </p>
   * <p>
   * Note that, due to Java's implementation of generics, arrays of primitives will ultimately
   * result in a List containing an array.
   * </p>
   *
   * @param <T> Generic input class identifier
   * @param <R> Generic return class identifier
   * @param list Input array
   * @return Flattened list
   * @since 1.1.0
   */
  @SuppressWarnings("unchecked")
  public static <T, R> List<R> flatten(T[] list) {
    if (list.length == 0 || !(list[0] instanceof List<?> || list[0].getClass().isArray())) {
      return (List<R>) new ArrayList<>(Arrays.asList(list));
    }
    List<R> flat = new ArrayList<>();
    if (list[0] instanceof List<?>) {
      for (T list1 : list) {
        for (int j = 0; j < ((List<T>) list1).size(); j++) {
          flat.add(((List<R>) list1).get(j));
        }
      }
    } else if (list[0].getClass().isArray()) {
      for (T list1 : list) {
        flat.addAll(Arrays.asList((R[]) list1));
      }
    } else {
      throw new AssertionError("Should never happen");
    }
    return flatten(flat);
  }

  /**
   * Returns a new flattened List.
   * <p>
   * For every element that is an array or List, extract its elements into the new List. Recursion
   * is limited to {@code level} iterations.
   * </p>
   * <p>
   * Note that, due to Java's implementation of generics, arrays of primitives will ultimately
   * result in a List containing an array, given a high enough {@code level}.
   * </p>
   *
   * @param <T> Generic input class identifier
   * @param <R> Generic return class identifier
   * @param list Input array
   * @param level Level of recursion to flatten
   * @return Flattened list
   * @since 1.1.0
   */
  @SuppressWarnings("unchecked")
  public static <T, R> List<R> flatten(T[] list, int level) {
    if (list.length == 0 || !(list[0] instanceof List<?> || list[0].getClass().isArray())
        || level == 0) {
      return (List<R>) new ArrayList<>(Arrays.asList(list));
    }
    if (list[0].getClass().isArray() && list[0].getClass().getComponentType().isPrimitive()) {
      return flatten((R[]) list);
    }
    List<R> flat = new ArrayList<>();
    if (list[0] instanceof List<?>) {
      for (T list1 : list) {
        for (int j = 0; j < ((List<T>) list1).size(); j++) {
          flat.add(((List<R>) list1).get(j));
        }
      }
    } else if (list[0].getClass().isArray()) {
      for (T list1 : list) {
        flat.addAll(Arrays.asList((R[]) list1));
      }
    } else {
      throw new AssertionError("Should never happen");
    }
    return flatten(flat, level - 1);
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<int[]> flatten(int[][] list) {
    int size = 0;
    for (int[] arr : list) {
      size += arr.length;
    }
    List<int[]> flat = new ArrayList<>();
    flat.add(new int[size]);
    int i = 0;
    for (int[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<char[]> flatten(char[][] list) {
    int size = 0;
    for (char[] arr : list) {
      size += arr.length;
    }
    List<char[]> flat = new ArrayList<>();
    flat.add(new char[size]);
    int i = 0;
    for (char[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<double[]> flatten(double[][] list) {
    int size = 0;
    for (double[] arr : list) {
      size += arr.length;
    }
    List<double[]> flat = new ArrayList<>();
    flat.add(new double[size]);
    int i = 0;
    for (double[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<boolean[]> flatten(boolean[][] list) {
    int size = 0;
    for (boolean[] arr : list) {
      size += arr.length;
    }
    List<boolean[]> flat = new ArrayList<>();
    flat.add(new boolean[size]);
    int i = 0;
    for (boolean[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<short[]> flatten(short[][] list) {
    int size = 0;
    for (short[] arr : list) {
      size += arr.length;
    }
    List<short[]> flat = new ArrayList<>();
    flat.add(new short[size]);
    int i = 0;
    for (short[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<long[]> flatten(long[][] list) {
    int size = 0;
    for (long[] arr : list) {
      size += arr.length;
    }
    List<long[]> flat = new ArrayList<>();
    flat.add(new long[size]);
    int i = 0;
    for (long[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<float[]> flatten(float[][] list) {
    int size = 0;
    for (float[] arr : list) {
      size += arr.length;
    }
    List<float[]> flat = new ArrayList<>();
    flat.add(new float[size]);
    int i = 0;
    for (float[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Converts an array of primitive arrays into a List of one primitive array.
   *
   * @param list Input array
   * @return Flattened list
   * @since 1.3.1
   */
  public static List<byte[]> flatten(byte[][] list) {
    int size = 0;
    for (byte[] arr : list) {
      size += arr.length;
    }
    List<byte[]> flat = new ArrayList<>();
    flat.add(new byte[size]);
    int i = 0;
    for (byte[] arr : list) {
      for (int j = 0; j < arr.length; j++) {
        flat.get(0)[i] = arr[j];
        i++;
      }
    }
    return flat;
  }

  /**
   * Ensures the size of {@code list} is at least {@code size}.
   * <p>
   * If the list size is less than required, {@code null} is appended until the values are equal.
   * </p>
   * <p>
   * Note that it is considered best practice to use interfaces over implementations of those
   * interfaces where possible, but in cases where an {@code ArrayList} must be used, this version
   * can be faster.
   * </p>
   *
   * @param list List to be resized
   * @param size Required size
   * @since 1.2.0
   */
  public static void ensureSize(ArrayList<?> list, int size) {
    list.ensureCapacity(size);
    while (list.size() < size) {
      list.add(null);
    }
  }

  /**
   * Ensures the size of {@code list} is at least {@code size}.
   * <p>
   * If the list size is less than required, {@code null} is appended until the values are equal.
   * </p>
   *
   * @param list List to be resized
   * @param size Required size
   * @since 1.2.0
   */
  public static void ensureSize(List<?> list, int size) {
    while (list.size() < size) {
      list.add(null);
    }
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input List.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> List, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param <T> Generic input class identifier
   * @param <R> Generic return class identifier
   * @param original Input list
   * @return Transposed list
   * @since 1.4.0
   */
  @SuppressWarnings({"unchecked", "SuspiciousToArrayCall"})
  public static <T, R> List<R> transpose(List<T> original) {
    if (original.isEmpty() || !(original.get(0) instanceof List<?> || original.get(0).getClass().isArray())) {
      return (List<R>) original;
    }
    if (original.get(0).getClass().isArray() && original.get(0).getClass().getComponentType().isPrimitive()) {
      if (original.get(0).getClass() == int[].class) { //In no particular order
        return (List<R>) transpose(original.toArray(new int[0][0]));
      }
      if (original.get(0).getClass() == byte[].class) {
        return (List<R>) transpose(original.toArray(new byte[0][0]));
      }
      if (original.get(0).getClass() == double[].class) {
        return (List<R>) transpose(original.toArray(new double[0][0]));
      }
      if (original.get(0).getClass() == boolean[].class) {
        return (List<R>) transpose(original.toArray(new boolean[0][0]));
      }
      if (original.get(0).getClass() == short[].class) {
        return (List<R>) transpose(original.toArray(new short[0][0]));
      }
      if (original.get(0).getClass() == long[].class) {
        return (List<R>) transpose(original.toArray(new long[0][0]));
      }
      if (original.get(0).getClass() == char[].class) {
        return (List<R>) transpose(original.toArray(new char[0][0]));
      }
      if (original.get(0).getClass() == float[].class) {
        return (List<R>) transpose(original.toArray(new float[0][0]));
      }
    }
    int rows = original.size();
    int columns;
    if (original.get(0) instanceof List<?>) {
      columns = ((List<T>) original.get(0)).size();
    } else {
      columns = ((T[]) original.get(0)).length;
    }
    List<List<T>> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new ArrayList<>());
      for (int i = 0; i < rows; i++) {
        if (original.get(0) instanceof List<?>) {
          if (((List<T>) original.get(i)).size() > columns) {
            columns = ((List<T>) original.get(i)).size();
          }
          if (((List<T>) original.get(i)).size() > j) {
            transposed.get(j).add(((List<T>) original.get(i)).get(j));
          } else {
            continue next;
          }
        } else {
          if (((T[]) original.get(i)).length > columns) {
            columns = ((T[]) original.get(i)).length;
          }
          if (((T[]) original.get(i)).length > j) {
            transposed.get(j).add(((T[]) original.get(i))[j]);
          } else {
            continue next;
          }
        }
      }
    }
    return (List<R>) transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param <T> Generic input class identifier
   * @param <R> Generic return class identifier
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  @SuppressWarnings("unchecked")
  public static <T, R> List<R> transpose(T[] original) {
    int rows = original.length;
    int columns;
    if (original[0] instanceof List<?>) {
      columns = ((List<T>) original[0]).size();
    } else {
      columns = ((T[]) original[0]).length;
    }
    List<List<T>> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new ArrayList<>());
      for (int i = 0; i < rows; i++) {
        if (original[0] instanceof List<?>) {
          if (((List<T>) original[i]).size() > columns) {
            columns = ((List<T>) original[i]).size();
          }
          if (((List<T>) original[i]).size() > j) {
            transposed.get(j).add(((List<T>) original[i]).get(j));
          } else {
            continue next;
          }
        } else {
          if (((T[]) original[i]).length > columns) {
            columns = ((T[]) original[i]).length;
          }
          if (((T[]) original[i]).length > j) {
            transposed.get(j).add(((T[]) original[i])[j]);
          } else {
            continue next;
          }
        }
      }
    }
    return (List<R>) transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<int[]> transpose(int[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<int[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new int[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<double[]> transpose(double[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<double[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new double[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<byte[]> transpose(byte[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<byte[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new byte[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<float[]> transpose(float[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<float[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new float[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<long[]> transpose(long[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<long[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new long[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<short[]> transpose(short[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<short[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new short[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<char[]> transpose(char[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<char[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new char[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }

  /**
   * Returns an <i>n</i>-dimensional List that is the matrix transposition on the input array.
   * <p>
   * Given an <i>i</i>-by-<i>j</i> array, transpose it to a <i>j</i>-by-<i>i</i> List.
   * </p>
   *
   * @param original Input array
   * @return Transposed list
   * @since 1.4.0
   */
  public static List<boolean[]> transpose(boolean[][] original) {
    int rows = original.length;
    int columns = original[0].length;
    List<boolean[]> transposed = new ArrayList<>();
    next:
    for (int j = 0; j < columns; j++) {
      transposed.add(new boolean[rows]);
      for (int i = 0; i < rows; i++) {
        if (original[i].length > columns) {
          columns = original[i].length;
        }
        if (original[i].length > j) {
          transposed.get(j)[i] = original[i][j];
        } else {
          continue next;
        }
      }
    }
    return transposed;
  }
}

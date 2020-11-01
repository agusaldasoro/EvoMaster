package com.foo.rest.examples.spring.market.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * This class models the result of a query to a repository where multiple objects were selected. As repositories allow
 * to select a range of objects via offset and limit, we need to support returning only the selected subset but at
 * the same time provide a mechanism to let the client know the total number of elements that could be obtained by
 * increasing the offset in order to traverse the full results list.
 *
 * @param <T> the type of elements in the collection
 */
public class PagedCollection<T> implements Collection<T> {
	private final List<T> pageElements;
	private final int totalSize;

	/** Constructor */
	public PagedCollection(List<T> pageElements, int totalSize) {
		this.pageElements = pageElements;
		this.totalSize = totalSize;
	}

	/**
	 * Returns the total count of elements in the collection satisfying the initial filter, regardless of the requested
	 * page
	 */
	public int getTotalSize() {
		return totalSize;
	}

	@Override
	public int size() {
		return pageElements.size();
	}

	@Override
	public boolean isEmpty() {
		return pageElements.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return pageElements.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return pageElements.containsAll(c);
	}

	@Override
	public Iterator<T> iterator() {
		return pageElements.iterator();
	}

	@Override
	public Object[] toArray() {
		return pageElements.toArray();
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		return pageElements.toArray(a);
	}

	@Override
	public boolean add(T t) {
		throw new UnsupportedOperationException("This is an immutable collection");
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("This is an immutable collection");
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException("This is an immutable collection");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("This is an immutable collection");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("This is an immutable collection");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("This is an immutable collection");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PagedCollection<?> that = (PagedCollection<?>) o;

		if (totalSize != that.totalSize) return false;
		return pageElements.equals(that.pageElements);

	}

	@Override
	public int hashCode() {
		int result = pageElements.hashCode();
		result = 31 * result + totalSize;
		return result;
	}

	@Override
	public String toString() {
		return "PagedCollection{" +
				"pageElements=" + pageElements +
				", totalSize=" + totalSize +
				'}';
	}

}
